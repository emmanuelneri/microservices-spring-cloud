FROM node:9.11.1-alpine

RUN apk update \
  && apk add --update alpine-sdk python \
  && apk add bash \
  && yarn global add @angular/cli@1.6.8 \
  && ng set --global packageManager=yarn \
  && apk del alpine-sdk python \
  && rm -rf /tmp/* /var/cache/apk/* *.tar.gz ~/.npm \
  && npm cache clean --force \
  && yarn cache clean

WORKDIR /web

ADD . .

RUN npm install

EXPOSE 4200

CMD ["ng", "serve"]
