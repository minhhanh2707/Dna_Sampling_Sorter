# Dna_Sampling_Sorter

A Java-based data processing program designed to analyze paired bacterial DNA sample sequences and identify changes in their nucleotide-marker distributions across two testing periods.

By automating sequence parsing, frequency counting, percentage normalization, and distribution comparison, the program transforms raw sequence data into structured analytical results, reducing repetitive manual calculations and providing a consistent approach to screening potential mutations under predefined criteria.

Algorithm:

1. Reads the sequence from an external input file.
2. Normalizes character cases to ensure consistent processing.
3. Filters the sequence to retain only A, B, C, and D.
4. Counts the occurrences of each selected marker.
5. Calculates each marker's percentage relative to the total number of valid markers.
6. Compares the percentage distributions of the two samples.
7. Classifies the result as `MATCH` or `DIFFERENT`.
8. Exports the calculated results to an external output file.
