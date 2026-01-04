{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE OverloadedStrings #-}

import Data.Aeson (FromJSON, ToJSON)
import GHC.Generics (Generic)
import Web.Scotty

data SumData = SumData
  { x :: Int,
    y :: Int
  }
  deriving (Show, Generic)

instance FromJSON SumData

instance ToJSON SumData

main :: IO ()
main = scotty 3000 $ do
  post "/sum" $ do
    input <- jsonData :: ActionM SumData
    let outputData = (+) <$> Just (x input) <*> Just (y input)
    json outputData
