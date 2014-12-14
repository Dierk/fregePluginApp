Under Construction
==================

this is a first, initial, preliminary sample Grails application that uses the
Frege Plugin.

It is all work in progress and only here that interested parties can get a
sneek peek. Do not expect any convenience. Do not expect any support, yet.

**Do not expect production quality in any regard!**


If you really want to build it
------------------------------

The expects the plugin to be in a sibling folder in order to use it as inline plugin.
See grails-app/conf/BuildConfig.

The mutual compile dependencies between Frege and Groovy are not yet resolved.
For the initial compile:
- first compile without Frege code (rename or move it away or so...).
- then compile a second time with the Frege code.