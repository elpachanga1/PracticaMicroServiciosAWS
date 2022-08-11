# stage 1
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --docker

# stage 2
FROM nginx:latest
COPY --from=node /app/dist/client-bank-v12 /usr/share/nginx/html
EXPOSE 80

# commands
# docker build -t aforo255/frontend-angular  .
# docker run --rm -d --name=frontend-angular --network=micro -p 11000:80 aforo255/frontend-angular
