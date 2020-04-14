#!/bin/bash

if [[ -z $1 ]]; then
    echo "No argument given. Exiting"
    exit 0;
fi

# Vars do change
config_file="/Users/danielbrackin/Desktop/yamls/$1"
reponame=$(cat $config_file | yq .default_context.app_name | tr -d '"')
description=$(cat $config_file | yq .default_context.description | tr -d '"')

# Vars don't change
output_dir="/Users/danielbrackin/Desktop/"
username="danielbrackin"

echo "Executing command: cookiecutter --config-file $config_file -o $output_dir -f"
read -p "Run cookiecutter for "$reponame" (y/n)?: "  choice

case "$choice" in 
  # Execute cookiecutter
  y|Y ) cookiecutter -f --config-file $config_file -o $output_dir --no-input .;;
  # Skip cookiecutter
  * ) echo "Stopping script";exit 1;;
esac

cd $output_dir/$reponame
response=$(curl -s -o /dev/null -w "%{http_code}" -u $username https://api.github.com/user/repos -d "{\"name\":\"$reponame\", \"description\":\"$description\", \"private\": true}")
case "$response" in
        200) echo git curl successful ;;
        201) echo git curl successful ;;
        301) echo git curl successful ;;
        304) printf "Received: HTTP $response (file unchanged) - Exiting";exit 1;;
        404) printf "Received: HTTP $response (file not found) - Exiting";exit 1;;
          *) printf "Received: HTTP $response - Exiting";exit 1;;
esac
git init
git add --all
git commit -m "First push using run.sh"
git remote add origin git@github.com:$username/$reponame.git
git push -u origin master