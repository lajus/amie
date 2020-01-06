# AMIE 

AMIE is a system to mine Horn rules on RDF knowledge bases. An RDF knowledge base is a collection of facts of the form <subject, relation, object> such as <Elvis, bornIn, Tupelo>. AMIE can find rules accurate rules such as locatedInCity(x, y) ^ locatedInCountry(y, z) => locatedInCountry(x, z) from large knowledge bases. AMIE stands for Association Rule Mining under Incomplete Evidence. 

Its latest version is AMIE 3. Previous version of AMIE can be downloaded [here](https://www.mpi-inf.mpg.de/departments/databases-and-information-systems/research/yago-naga/amie/)

## Dependencies

* Java >= 7
* Apache Commons >= 1.2
* [Javatools](https://www.mpi-inf.mpg.de/departments/databases-and-information-systems/research/yago-naga/javatools/) and "telecom-utils". Both packages can be found as maven projects here: https://github.com/lajus/amie-utils.

## Deployment

* AMIE is managed with [Maven](https://maven.apache.org/)


## Known bug

AMIE main class (amie.mining.AMIE) will, by default, print the rules during the mining phase. However, on some recent JVM, the Thread handling the printing may run indefinitely. I suggest you for now to use the "-oute" option, that prints all the rules found only at the end of the mining process, but also disable the faulty Thread. 

# Publications 

## AMIE 3

Lajus, J., Galárraga, L., & Suchanek, F. M (2020). Fast and Exact Rule Mining with AMIE 3. Under revision at the Extended Semantic Web Conference.

## Typing

Source files for:

Lajus, J., & Suchanek, F. M. (2018, April). Are All People Married?: Determining Obligatory Attributes in Knowledge Bases. 
In Proceedings of the 2018 World Wide Web Conference on World Wide Web (pp. 1115-1124). International World Wide Web Conferences Steering Committee.

article: https://suchanek.name/work/publications/www-2018.pdf

Codes in: kb/ rosa/ rules/ 
