Frudo-Blocks
============

Frudo-Block is a Block Programming Languaged based on ArduBlock. The software has been build up specifically for Frudino Board by Frugal-Labs
The language and functions model closely to Arduino Language Reference


Installation

The project is managed by Maven. After checking out the source for the first time, one should run the following to install Arduino's pde.jar into the local repository.

$ mvn validate
Usage

$ mvn exec:java -Dexec.mainClass="com.frugalblock.Main"

$ mvn clean package

$ mvn compile exec:java -Dexec.mainClass="com.frugalblock.Main"

Authors

rakendrathapa@gmail.com

FrugalBlock is modified ArduBlock. It is a free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

FrugalBlock is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with FrugalBlock. If not, see http://www.gnu.org/licenses/.
