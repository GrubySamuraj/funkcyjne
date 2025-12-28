{-# LANGUAGE OverloadedStrings #-}

import Control.Monad.IO.Class (liftIO)
import Data.Aeson (FromJSON, ToJSON)
import Data.Text.Lazy (pack)
import GHC.Generics (Generic)
import System.Random (randomRIO)
import Web.Scotty

main :: IO ()
main = scotty 3000 $ do
  get "/" $ do
    text "Witaj! To jest serwer Scotty postawiony od zera."

  get "/randomInt" $ do
    liczba <- liftIO $ randomRIO (0, maxBound :: Int)
    json liczba

  get "/randomFloat" $ do
    numFloat <- liftIO $ randomRIO (0, 1 :: Double)
    json numFloat