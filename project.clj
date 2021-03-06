(defproject samu "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :main samu.srv

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.773"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.2"]
                 [hiccup "1.0.5"]
                 [org.clojure/data.json "2.4.0"]
                 [binaryage/oops "0.7.2"]]

  :source-paths ["src"]

  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:test"  ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" "samu.test-runner"]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.15"]
                                  [com.bhauman/rebel-readline-cljs "0.1.4"]]
                   :clean-targets ^{:protect false} [:target-path "resources/public/cljs-out"]}})

