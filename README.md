<img src="https://raw.githubusercontent.com/st235/Identicons/master/pictures/logo.png" width="128" height="128">

# Identicons

Probably the most original way to visualize hashes.

## Screens
<img src="https://raw.githubusercontent.com/st235/Identicons/master/pictures/homescreen.png" width="270" height="480"> <img src="https://raw.githubusercontent.com/st235/Identicons/master/pictures/app.png" width="270" height="480">

## Installation

From maven

```xml
<dependency>
  <groupId>com.github.st235</groupId>
  <artifactId>identiconview</artifactId>
  <version>0.0.1</version>
  <type>pom</type>
</dependency>
```

From gradle

```
compile 'com.github.st235:identiconview:0.0.1'
```

## Usage
To begin is the most difficult.
I prepared the opportunity to configure the view straight from the markup.

```xml
    <st235.github.com.identiconview.IdenticonView
        android:id="@+id/identicon"
        android:layout_width="84dp"
        android:layout_height="84dp"
        app:text="hello world!"
        app:colorMode="manual"
        app:cellsColor="@color/colorPrimary"
        app:backgroundColor="@color/colorAccent"/>
```

The **text** field allows you to enter text based on which the hash will be considered.

**colorMode** - sets the mode for controlling the color of the shape. There are 2 modes: _automatic_ and _manual_. In _manual_ mode, you need to specify **cellsColor** and **backgroundColor**, whereas in the _automatic_ mode, they will be calculated based on the hash.


### Code API

All listed ways of controlling the view have a mapping in the api.

```java
    private IdenticonView identiconView;

    ...
    @Override
    public void afterTextChanged(Editable editable) {
        identiconView.setText(editable.toString());
    }
    ...    
```

IdenticonView interface

```java
public void setText(@Nullable String text)
public void setColors(@ColorInt int cellsColor, @ColorInt int backgroundColor)
public void resetColors() 
public void setFieldProvider(@Nullable IdenticonFieldProvider fieldProvider)
```

## License

MIT License

Copyright (c) 2018 Alexander Dadukin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
