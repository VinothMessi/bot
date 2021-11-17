#!/usr/bin/env bash
# Environment Variables
#$PROFILE
#$BROWSER
#$HOST
#$PORT
#$MODULE

echo "Checking if hub is ready - $HOST"

while [ "$( curl -s http://$HOST:$PORT/wd/hub/status | jq -r .value.ready )" != "true" ]
do
	sleep 1
done

# start the java command
java -cp bot.jar:bot.jar.original:bot-tests.jar:libs/* -Dspring.profiles.active=$PROFILE -Dbrowser=$BROWSER -Dhub.host=$HOST -Dhub.port=$PORT org.testng.TestNG $MODULE