FROM haskell:9.10

WORKDIR /app

COPY . .
RUN stack build --system-ghc

EXPOSE 3000

CMD ["stack", "run"]