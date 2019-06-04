#!/bin/bash
# to kill multiple runaway processes, use 'pkill runaway_process_name'
# For the Java implementation, use the following format: ./tests1.sh your_client.class [-n]
logDir="./logs"
algos="ff bf wf bu bp"
ClientClass= $2
configDir="./configs"

if [ ! -d $logDir ]; then
	mkdir $logDir
else
	rm $logDir/* &> /dev/null
fi



trap "kill 0" EXIT
echo "$logDir/$(sed 's/.*\///' <<< $1)-$algo.log"

for conf in ${configDir}/*.xml; do
 confFile=${conf:10}
 echo "running $confFile" 
for algo in $algos; do
	logFile=$logDir/$(sed 's/.*\///' <<< $1)-$confFile-$algo.log
	echo "running $algo...$logFile"
	./ds-server -c ${conf} -v brief -n > $logFile&
	sleep 1
	echo "client running..."
    java Client -a $algo
	sleep 2
done
done
echo hello!!!

n=0

for log in $logDir/*.log; do
    if [[ -f ${log} ]]; then
        echo "$(basename ${log}):"
        if (( ${n} == 0 )); then
        	# https://stackoverflow.com/a/24017666/8031185
            sed '/^t:/h;//!H;$!d;x' ${log}
        else
            tail -${n} ${log}
        fi
        echo ""
    fi
done
