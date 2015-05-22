
"The quick brown fox jumps over the lazy dog."
  .toLowerCase
  .split("\\W+")
  .groupBy((word: String) => word)
  .mapValues(_.length)
  .toList
  .sortBy(-_._2)