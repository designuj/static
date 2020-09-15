# Local
### Remove old containers
```
docker rm -f \
    app-backend \
    app-frontend \
    app-database \
    app-migration
```

### Fresh local startup
`docker-compose up --build`

### .env file
```
DB_HOST=app-database
DB_PORT=5432
DB_NAME=prototype
DB_USER=admin
DB_PASS=pass

JBOSS_SECRET=wildfly

APP_HOST=http://app-backend:8090/
```

# Prod
`tba`
`docker exec -it app-backend /bin/bash`
