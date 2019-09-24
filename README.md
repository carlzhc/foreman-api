# foreman-api

A Clojure library designed to be used in foreman client to interact with foreman
API.

## Usage

### Create/Update the api library file
- Set environment variables:
  - foreman_host: foreman server url, eg: "https://localhost"
  - foreman_auth: foreman login credential, eg: "admin:MySecretPassword"
  - foreman_insecure: whether to trust unsafe https connection, can be "yes" "no" "true" or "false"

- Generate api definition file (written to src/foreman_api/api_defs.clj):

      lein run src/foreman_api/api_defs.clj

  This will create the api defination file, and will be loaded by `api.clj`.

- Create an update jar file

    lein uberjar

### Use the library in your app
- In your `project.clj` file, add:
  [[https://clojars.org/carlzhc/foreman-api][https://img.shields.io/clojars/v/carlzhc/foreman-api.svg]]

- In your clojure source files, add:

      (require '[foreman-api :as api])

## License

Copyright © 2019 CARLZHC

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
