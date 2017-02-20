ROCKS DB SERVER

Download:
	git clone https://github.com/koek67/rocks-db-server

Install:
	./gradlew build

Run
	./gradlew bootRun

The server will run on http://localhost/8080

Testing

Setting a key value pair ("key", "value"):
curl -X POST -H "Cache-Control: no-cache" -F "key=key" -F "value=value" "http://localhost:8080/set"

Retrieve the value back:
curl -X GET -H "Cache-Control: no-cache" "http://localhost:8080/get?key=key"
