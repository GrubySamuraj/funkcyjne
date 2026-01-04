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

data ConcatData = ConcatData
  { list1 :: [String],
    list2 :: [String],
    list3 :: [String]
  }
  deriving (Show, Generic)

instance FromJSON SumData

instance ToJSON SumData

instance FromJSON ConcatData

instance ToJSON ConcatData

main :: IO ()
main = scotty 3000 $ do
  post "/sum" $ do
    input <- jsonData :: ActionM SumData
    let outputData = (+) <$> Just (x input) <*> Just (y input)
    json outputData

  post "/concat" $ do
    input2 <- jsonData :: ActionM ConcatData
    let output = mconcat [list1 input2, list2 input2, list3 input2]
    json output

  post "/sumList" $ do
