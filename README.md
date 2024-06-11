This library can do all sorts of convolutions with more edge handling than the Standard Java Library. 
It requires the use of a subclass of ```Convolve```, and a subclass of ```Kernel```, or, optionally, 
use the ```Kernel``` class to use a custom matrix for the ```Kernel``` provided a 2D array
of doubles.
Here is an example:
```
Convolve conv = new ConvolveReflect(new BlurKernel(10));
BufferedImage in = ImageIO.read(new File("example.png"));
BufferedImage out = conv.filter(in);
```

The subclasses of Convolve are specified by how the edge handling works, and include the following:
```ConvolveNoOp``` - Returns the original image's pixel when handling edges.
```ConvolveZero``` - Returns the color black when handling edges.
```ConvolveWrap``` - Returns a pixel from the oppopsite edge when handling edges.
```ConvolveReflect``` - Returns a pixel mirrored by the distance from the edge when handling edges.
```ConvolveReflect``` is recommended for most cases.

The subclasses of Kernel are specified by what values are in it's matrix, and include the following:
```BlurKernel``` - All values in kernel are equal and are a fraction of the kernel's size .
```GaussBlurKernel``` - Values in the kernel increase in size as you approach the center of the matrix.
```EmbossKernel``` - Values in the kernel are positive around the top left corner, negative around the 
      bottom right corner,  and have a line of zeroes from the bottom left corner to the top right 
      corner.
```SharpenKernel``` - Values in the kernel are a negative fraction of the size of the kernel, except 
      for the center value, which is one plus that (negative) fraction.
The Prewitt, Sobel and Scharr ```Kernel```s can be specified horizontally or vertically, and always
      contain a 3x3 matrix.

