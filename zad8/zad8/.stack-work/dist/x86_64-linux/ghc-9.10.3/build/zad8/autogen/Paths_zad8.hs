{-# LANGUAGE CPP #-}
{-# LANGUAGE NoRebindableSyntax #-}
#if __GLASGOW_HASKELL__ >= 810
{-# OPTIONS_GHC -Wno-prepositive-qualified-module #-}
#endif
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
{-# OPTIONS_GHC -w #-}
module Paths_zad8 (
    version,
    getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where


import qualified Control.Exception as Exception
import qualified Data.List as List
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude


#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir `joinFileName` name)

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath




bindir, libdir, dynlibdir, datadir, libexecdir, sysconfdir :: FilePath
bindir     = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/bin"
libdir     = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/lib/x86_64-linux-ghc-9.10.3-df3b/zad8-0.1.0.0-6xao7CTSbwY3SQ5zHwviOj-zad8"
dynlibdir  = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/lib/x86_64-linux-ghc-9.10.3-df3b"
datadir    = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/share/x86_64-linux-ghc-9.10.3-df3b/zad8-0.1.0.0"
libexecdir = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/libexec/x86_64-linux-ghc-9.10.3-df3b/zad8-0.1.0.0"
sysconfdir = "/home/jdragosz/Studia/funkcyjne/funkcyjne/zad8/zad8/.stack-work/install/x86_64-linux/39ccc5c101882d82766dd75aa79eae2bf63789bc5f39a50ffaabcdb3bc9f652f/9.10.3/etc"

getBinDir     = catchIO (getEnv "zad8_bindir")     (\_ -> return bindir)
getLibDir     = catchIO (getEnv "zad8_libdir")     (\_ -> return libdir)
getDynLibDir  = catchIO (getEnv "zad8_dynlibdir")  (\_ -> return dynlibdir)
getDataDir    = catchIO (getEnv "zad8_datadir")    (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "zad8_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "zad8_sysconfdir") (\_ -> return sysconfdir)



joinFileName :: String -> String -> FilePath
joinFileName ""  fname = fname
joinFileName "." fname = fname
joinFileName dir ""    = dir
joinFileName dir fname
  | isPathSeparator (List.last dir) = dir ++ fname
  | otherwise                       = dir ++ pathSeparator : fname

pathSeparator :: Char
pathSeparator = '/'

isPathSeparator :: Char -> Bool
isPathSeparator c = c == '/'
