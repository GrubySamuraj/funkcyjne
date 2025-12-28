{-# LANGUAGE OverloadedStrings #-}

import Control.Monad.IO.Class (liftIO)
import Data.Aeson (FromJSON, ToJSON)
import Data.Text.Lazy (pack)
import GHC.Generics (Generic)
import System.Random (randomRIO)
import Web.Scotty

getRandomInt :: IO Int
getRandomInt = randomRIO (0, maxBound :: Int)

getRandomDouble :: IO Double
getRandomDouble = randomRIO (0, 1) :: IO Double

main :: IO ()
main = scotty 3000 $ do
  get "/" $ do
    text "Witaj! To jest serwer Scotty postawiony od zera."

  get "/randomInt" $ do
    liczba <- liftIO getRandomInt
    json liczba

  get "/randomDouble" $ do
    numFloat <- liftIO getRandomDouble
    json numFloat

  get "/randomPairs" $ do
    i <- liftIO getRandomInt
    d <- liftIO getRandomDouble
    d2 <- liftIO getRandomDouble
    d3 <- liftIO getRandomDouble

    json
      ( (i, d),
        (d, i),
        (d, d2, d3)
      )