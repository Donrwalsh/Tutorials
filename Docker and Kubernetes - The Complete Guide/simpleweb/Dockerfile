# Specify a base image
FROM node:alpine

# Specify that our COPY instruction should use the given WORKDIR instead of the root directory
WORKDIR /usr/app

# Include project files inside container
COPY ./ ./

# Install some dependencies
RUN npm install

# Default command
CMD ["npm", "start"]