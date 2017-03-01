ROCKS DB SERVER
=======================================================

Download:
	git clone https://github.com/koek67/rocks-db-server

Install:
	./gradlew build

Run:
	./gradlew bootRun

The server will run on http://localhost:8080

Setting a key value pair ("key", "value") in database "db":
curl -X POST -F "db"="db" -F "key=key" -F "value=value" "http://localhost:8080/set"

Retrieve the value back:
curl -X GET "http://localhost:8080/get?db=db&key=key"
