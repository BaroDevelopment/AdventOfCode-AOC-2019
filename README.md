# AdventOfCode2019
> Day 1: The Tyranny of the Rocket Equation ---
Santa has become stranded at the edge of the Solar System while delivering presents to other planets! To accurately calculate his position in space, safely align his warp drive, and return to Earth in time to save Christmas, he needs you to bring him measurements from fifty stars.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

The Elves quickly load you into a spacecraft and prepare to launch.

At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper. They haven't determined the amount of fuel required yet.

Fuel required to launch a given module is based on its mass. Specifically, to find the fuel required for a module, take its mass, divide by three, round down, and subtract 2.

## Example

For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
For a mass of 1969, the fuel required is 654.
For a mass of 100756, the fuel required is 33583.
The Fuel Counter-Upper needs to know the total fuel requirement. To find it, individually calculate the fuel needed for the mass of each module (your puzzle input), then add together all the fuel values.

What is the sum of the fuel requirements for all of the modules on your spacecraft?


## Input
```
140517
61738
141916
78376
69208
131761
67212
137805
79089
100457
108707
75235
51118
149457
68888
85722
91418
74481
93441
124911
75441
101542
149092
83149
139256
83398
76398
132252
137763
142758
136279
126238
102888
108723
119982
65216
61412
120894
118761
100221
67132
115494
95623
52819
78612
125505
80523
97774
67569
114514
131671
149811
77679
65540
98415
60595
105589
81927
60249
62514
139506
149532
146885
148831
142896
106300
106313
101456
96521
67104
142037
128258
128769
135081
93181
50735
147720
73775
58113
53478
96705
122060
135329
121513
54539
62404
66334
116924
90977
135383
51479
87581
124040
64048
78616
128068
148184
71714
58847
84640
```