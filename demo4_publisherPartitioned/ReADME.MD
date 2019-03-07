for statefull use case.
partionid will be the key and will persist connection with a single partion

to simulate : post 3 differents staionid and aunch 3 differents subscribers.
each partionid will be stuch with a single one subscriber.  


from subscriber : use this --spring.cloud.stream.instanceIndex=0 , then 1 then 2

on terinal run : 
curl --header "Content-Type: application/json"   --request POST   --data '{"stationId":"10","customeId":"30","timestamp":"now"}'   http://localhost:8082/toll
curl --header "Content-Type: application/json"   --request POST   --data '{"stationId":"20","customeId":"30","timestamp":"now"}'   http://localhost:8082/toll
curl --header "Content-Type: application/json"   --request POST   --data '{"stationId":"30","customeId":"30","timestamp":"now"}'   http://localhost:8082/toll


