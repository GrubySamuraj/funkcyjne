{-# LANGUAGE DeriveGeneric #-}
{-# LANGUAGE OverloadedStrings #-}

import Data.Aeson (FromJSON, ToJSON)
import Data.List (sort)
import GHC.Generics (Generic)
import Web.Scotty

data IsSortedData = IsSortedData
  { arrayToCheck :: [Int]
  }
  deriving (Generic)

data SummedData = SummedData
  { list1 :: [Int],
    list2 :: [Int],
    list3 :: [Int]
  }
  deriving (Generic, Show)

data SetHeadData = SetHeadData
  { listHead :: Int,
    list :: [Int]
  }
  deriving (Generic, Show)

data AppendData = AppendData
  { listAppend :: [Int],
    elementToAdd :: Int,
    indexToInsert :: Int
  }
  deriving (Generic, Show)

data SquaresData = SquaresData
  { list_1 :: [Int],
    list_2 :: [Int]
  }
  deriving (Generic, Show)

instance FromJSON IsSortedData

instance ToJSON IsSortedData

instance FromJSON SummedData

instance ToJSON SummedData

instance FromJSON SetHeadData

instance ToJSON SetHeadData

instance FromJSON AppendData

instance ToJSON AppendData

instance FromJSON SquaresData

instance ToJSON SquaresData

main :: IO ()
main = scotty 3000 $ do
  get "/" $ do
    text "Dziala na konfiguracji Cabal!"

  post "/isSorted" $ do
    inputArr <- jsonData :: ActionM IsSortedData
    let lista = arrayToCheck inputArr

    if lista == sort lista
      then text "Tak! Lista jest posortowana!"
      else text "Nie! Lista nie jest posortowana!"

  post "/sum" $ do
    lists <- jsonData :: ActionM SummedData
    let l1 = list1 lists
    let l2 = list2 lists
    let l3 = list3 lists

    json $ zipWith (+) l1 (zipWith (+) l2 l3)

  post "/setHead" $ do
    bodySetHead <- jsonData :: ActionM SetHeadData

    json $ listHead bodySetHead : list bodySetHead

  post "/append" $ do
    obj <- jsonData :: ActionM AppendData

    let lista = listAppend obj
    let element = elementToAdd obj
    let idx = indexToInsert obj

    let wynik = take idx lista ++ [element] ++ drop idx lista

    json wynik
  post "/squares" $ do
    obj2 <- jsonData :: ActionM SquaresData

    let l_1 = list_1 obj2
    let l_2 = list_2 obj2

    let wynik = zipWith (\x y -> x ^ 2 + y ^ 2) l_1 l_2

    json wynik