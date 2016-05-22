#### ObjectAnimator:
	
ObjectAnimator的概念这里就不解释了，直接从代码中说明，以下是模仿Persicope的加载动画，简单的几行代码即可实现，当然我也是模仿的，更好的实现思路还请各位朋友自己仔细思考。

**先说说我的思路：** 

首先下载Periscope然后改名zip解包，获取对应的png图片（搜索相关的loading文件：ps__bg_loading.png），看到了该文件的大小，仔细观察后，发现可以把很多张图连在一起从右-->左的连续位移动画，而这里我用到了属性动画，当然不是最好的选择，而且我这里实现的方法很笨，就是将两个LinearLayout不同x的坐标轴同样的距离和时间进行右到左的translate。实现结果如下图：
	
#### Demo GIF:
			
![Loading](https://raw.githubusercontent.com/eterrao/AnimationExamples/master/periscopeLoading.gif)


**Demo地址：** <https://github.com/eterrao/AnimationExamples>

**有必要把该问题记录一下**
 
关于上述动画，远远没我想的那么简单，原本以为两个ObjectAnimator就搞定的效果，结果弄了一下午也没有调好。

**说下问题**

- 没有平缓的过度效果，所以会导致动画很生硬，一下子显示出来的感觉真心不爽。
- 再打了Log后，发现repeatCount并不是那么好用，不知道什么原因，我发现在addListener以后，repeat这个方法会一直被调用，是否会出现内存泄露的问题，还有待检验，但不稳定也让我捏了一把汗，考虑不够严密。这并不是经验的问题，所以要自我反省反省，别光看到效果就觉得挺满意。
- 不够灵活，和业务的耦合性太强，导致业务稍微一变，动画这边的代码就受大的影响。设计模式太重要了！

**之后会继续进行改进**