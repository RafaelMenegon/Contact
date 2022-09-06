# Contact
I I build this project using, kotlin, gradle, springboot, and I create a dockerFile to be able run an image of docker

Curl to crate a contact 
curl --location --request POST 'localhost:8085/contact' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Rafael Menegon",
    "mobile": "10335641"
}'

Curl to get some contact
curl --location --request GET 'localhost:8085/contact/99' \
--data-raw ''
