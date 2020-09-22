# Security

## Use case
This example demonstrates:
- Vulnerabilities
- Security Hotspots

It also demonstrates the possibility to define your own custom sources, sanitizers and sinks to detect more injection cases
(or avoid false positives)

## Usage

Run `./run.sh`

Project consists of a basic start of an app implementation with a number of Vulnerabilities and Security Hotspots.

## Custom security configuration 
There is a sample framework class with a bunch of methods that demonstrate custom injections.
- The method without sanitization has an injection vulnerability
- The method with custom sanitization has no vulnerability

The custom security configuration file is in the root directory. Thie script `runCustom.sh` will re-run analysis with the configuration in place so the vulnerability can be found.
