#!/bin/sh
echo -e "start .."
source /etc/profile
nohup java -server -Xms1000m -Xmx1000m -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=7184  -Dapp_name=report -jar /home/admin/software/report/report.jar 1>>/home/admin/software/report/report.log 2>&1  &

echo "start report success..."