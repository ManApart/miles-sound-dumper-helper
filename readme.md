## Helper for the [Apex Sound Dumper](https://github.com/Lyxica/Miles-10-Sound-Dumper)

When I found the Apex sound dumper it didn't have a way to mass export songs because songs that loop would hang any sort of batch/ranged read. This app multi-threads song exports and has a configurable (aka hard coded) timeout so songs that loop won't prevent the export.