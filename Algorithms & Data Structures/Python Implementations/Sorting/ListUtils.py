# some_file.py
import sys
# insert at 1, 0 is the script path (or '' in REPL)
sys.path.insert(1, '/path/to/Python Implementations/Helper/')

import ListGenerator
print(list_generator.generate_fixed_size_sorted_list(), "hello")
