main = do
  putStrLn "Hello everybody!"
  putStrLn ("Please look at my favourite odd numbers: " ++ show ((filter odd [10 .. 20])))

sumtorial :: Integer -> Integer
sumtorial 0 = 0
sumtorial n = n + sumtorial (n - 1)

hailstone :: Integer -> Integer
hailstone n
  | n `mod` 2 == 0 = n `div` 2
  | otherwise = 3 * n + 1