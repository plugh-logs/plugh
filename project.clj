(defproject plugh "0.1.0-SNAPSHOT"
  :description "An open source log analysis tool"
  :url "http://plugh.im"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [http-kit "2.1.5"]
                 [org.clojure/core.match "0.2.0"]
                 ;;[org.clojure/core.logic "0.8.3"]
                 ;; [org.clojure/core.async "0.1.0-SNAPSHOT"]
                 [org.clojure/core.async "0.1.256.0-1bf8cf-alpha"]
                 ;; [org.clojure/tools.namespace "0.2.4"]
                 [org.clojure/clojurescript "0.0-2030"]
                 [com.novemberain/welle "1.5.0"]
                 [instaparse "1.2.2"]
                 [org.clojure/data.json "0.2.3"]
                 ]
  
  :profiles {:dev {:dependencies [[midje "1.5.0"]]}}
  
  :plugins [[lein-cljsbuild "0.3.3"]]
  
;;  :hooks [leiningen.cljsbuild]
  
  :cljsbuild {
              :builds
              {:dev
               {:source-paths ["clang_code" "resources/apps"]
                :compiler {:output-to "resources/target/js/clang_dbg.js"
                           :optimizations :whitespace
                           :pretty-print true
                           :source-map "resources/target/js/clang_dbg.js.map"}}
               
               :prod
               {:source-paths ["clang_code" "resources/apps" "resource/shared"]
                :compiler {:output-to "resources/target/js/clang.js"
                           :pretty-print false
                           :optimizations :whitespace}}
               
               :pre-prod
               {:source-paths ["clang_code" "resources/apps"]
                
                :compiler {:output-to "resources/target/js/clang_pre.js"
                           :optimizations :whitespace
                           :pretty-print false
                           }}}
              }

:repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/repositories/snapshots/"}
; :jvm-opts ["-Xmx512M"]
;; Control the context in which your project code is evaluated.
;; Defaults to :subprocess, but can also be :leiningen (for plugins)
;; or :classloader (experimental) to avoid starting a subprocess.
; :eval-in :classloader
:main plugh.core)
