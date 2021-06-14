FROM nginx:stable

# Make port 80 and 443 available to the world outside this container
EXPOSE 80 443

# Install curl
RUN apt-get update && apt-get install -y \
    curl \
 && rm -rf /var/lib/apt/lists/*

# Remove default config
RUN rm /etc/nginx/conf.d/*

# Copy custom config
COPY default.conf /etc/nginx/conf.d/default.template

# Remove default website
RUN rm -rf /usr/share/nginx/html/*

# Copy website artifacts
ARG DIST_DIR=dist/oom-frontend
ADD ${DIST_DIR} /usr/share/nginx/html

# Make sure nginx has all permissions
RUN chown -R nginx:nginx /usr/share/nginx
RUN chmod -R u+rwx /usr/share/nginx

CMD ["/bin/bash","-c","envsubst '$${BACKEND_HOST},$${BACKEND_PORT}' < /etc/nginx/conf.d/default.template > /etc/nginx/conf.d/default.conf && exec nginx -g 'daemon off;'"]
