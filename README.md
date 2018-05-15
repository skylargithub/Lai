Load Balancer
1. Layer 4 network level load balancer. Fast
2. Layer 7 load balancer. Application load balancer. Mose sophiscated. Route request based on business logic. Slower.
3. Enhance user experience by reducing the number of error reponses client sees. If server goes down, route to another working server
4. Session persistence. Send all requests from a paticular client to the same server each time. E-commerce shopping cart.

Reverse Proxit
1. Increased security - No information about backend server is visible outside. Protect servers from distruted denial of service(DDoS) attack.
2. Increased scalability and flexibility - Because clients see only the reverse proxy's IP address, you are freee o change the configuration of your backend infrastructure. Auto scaling.
3. Web accelearaion - compress server response to reduce the amount of bandwidth required.
4. Caching static content.
NGINX
https://www.nginx.com/resources/glossary/reverse-proxy-vs-load-balancer/
