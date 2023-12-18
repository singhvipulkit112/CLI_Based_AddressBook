# CLI_Based_AddressBook

Partitioning is done based on :
* First three digits of phone_number
* First Characters of both first_name and last_name

NOTE : But this would unevenly distribute the data since there are more words that start with 'a' than with 'z'.
So, some type of shard manager can be used which is trained on real data sets and assigns a shard based on that.
So if there are twice the amount of contacts for 's' as opposed to 'z' and 'x' combined, two shards can be used, one for 's', and another for 'z' and 'x'.
