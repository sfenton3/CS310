Scott Fenton
Homework 2

A part of my code that I thought was interesting was the doubleSize() method. I avoided explicitly rewriting the rehash collision algorithm by
instantiating another hashtable object and just using the put method to insert all the elements into another hashtable that was one size larger. I
also used the compareTo method to sort the words by alphabetical frequency, which made it much easier. In the main method all I did was read the hamlet.txt file
then, create an algorithm to define a word and put that word into a text array. Then I put that text array into my HashTableQuad and sorted it with another method
from that HashTableQuad class.