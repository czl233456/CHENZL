


### 1.SimpleAdapter



####  activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/my_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```



#### simpleitem.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView android:id="@+id/names"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:paddingLeft="10dp"
        android:textSize="20sp"/>

    <ImageView android:id="@+id/header"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_gravity="right"
        android:paddingRight="10dp"/>

</LinearLayout>
```



### MainActivity.java

```
package edu.finu.cse.myapplication;
import android.app.Activity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //定义数据
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private  int[] imageid = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,
                    R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.my_list);
        //创建list集合
        List<Map<String,Object>> listItems =
                new ArrayList<>();
        for (int i=0;i<names.length;i++)
        {
            Map<String,Object> listItem =new  HashMap<>();
            listItem.put("header",imageid[i]);
            listItem.put("names",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simpleitem,
                new String[]{"header","names"}
                ,new int[]{R.id.header,R.id.names});
        list.setAdapter(simpleAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),names[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```



### 结果

![](./image/1.png)





### 2.AlertDialog



#### activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:text="ANDROID APP"
        android:background="#fffacd"
        android:textColor="#000000"
        android:gravity="center"
        android:textSize="20dp"/>
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Username"
        android:textColor="@color/colorPrimary"
        android:textSize="20dp"/>
    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password"
        android:textSize="20dp"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:orientation="horizontal"
        android:paddingLeft="5dp"
        android:paddingRight="5dp">
        <Button
            android:id="@+id/button1"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:text="Cancel"
            android:background="#ffe4e1"
            android:textColor="#000000"/>
        <Button
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:text="Sign in"
            android:background="#ffe4e1"
            android:textColor="#000000" />
    </LinearLayout>
</LinearLayout>
```



#### MainActivity.java

```
package edu.finu.cse.myapplication;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder =new  AlertDialog.Builder(this);
        View view = View.inflate(MainActivity.this,R.layout.activity_main,null);
        builder.setView(view);

    }
}
```



#### 

### 结果

![](./image/2.png)









### 3.使用XML定义菜单



#### 

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/txt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="这是一个测试"/>
</LinearLayout>
```







```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android" >
    <item
        android:title="字体大小">
        <menu>
            <group android:checkableBehavior="single">
                <item android:id="@+id/size1"
                    android:title="小"/>
                <item android:id="@+id/size2"
                    android:title="中"/>
                <item android:id="@+id/size3"
                    android:title="大"/>
            </group>
        </menu>
    </item>
    <item android:id="@+id/item2"
        android:title="普通菜单项">
    </item>
    <item android:id="@+id/item3"
        android:title="字体颜色">
        <menu>
            <group android:checkableBehavior="single">
                <item android:id="@+id/colorRed"
                    android:title="红色"/>
                <item android:id="@+id/colorBlack"
                    android:title="黑色"/>
            </group>
        </menu>
    </item>
</menu>
```





### MainActivity.java

```
package edu.finu.cse.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        txt= findViewById(R.id.txt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.layout.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.size1:
                txt.setTextSize(10);
                break;
            case R.id.size2:
                txt.setTextSize(16);
            case R.id.size3:
                txt.setTextSize(20);
                break;
            case R.id.item2:
                Toast.makeText(this,"普通菜单项",Toast.LENGTH_SHORT).show();
            case R.id.colorRed:
                txt.setTextColor(Color.parseColor("#ff0000"));
                break;
            case R.id.colorBlack:
                txt.setTextColor(Color.parseColor("#000000"));
                break;
        }
        return true;
    }


}
```







### 结果

![](./image/3.png)





![](./image/4.png)



![](./image/5.png)



![](./image/6.png)









### 4.ActionMode





### MainActivity.java

```
package edu.finu.cse.shiyan3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"One", "Two", "Three", "Four", "Five"};
    private int[] imagesIds = new int[]{R.drawable.robot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
           
            listitem.put("imageview", imagesIds[0]);
            listitem.put("textview", names[i]);
            listitems.add(listitem);
        }
       
        final List<Item> list1= new ArrayList<Item>();
       
        for(int i = 0; i < names.length; i++){
            list1.add(new Item(names[i], false));
        }
        
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, listitems, R.layout.app, new String[]{"textview","imageview" }, new int[]{R.id.text, R.id.image});
        final ListView list = findViewById(R.id.myList);
        
        list.setAdapter(simpleAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            
            int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
               
                if (checked == true) {
                    list1.get(position).setBo(true);
                    
                    simpleAdapter.notifyDataSetChanged();
                    num++;
                } else {
                    list1.get(position).setBo(false);
                    
                    simpleAdapter.notifyDataSetChanged();
                    num--;
                }
                
                mode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
               
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        simpleAdapter.notifyDataSetChanged();
                        num = 0;
                        mode.finish(); 
                        return true;
                    default:
                        return false;
                }
            }

            @SuppressLint("ResourceType")
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                
                num = 0;
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.layout.main_menu,menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
               
                return false;
            }
        });
    }
}

```





### Item.java

```
package edu.finu.cse.shiyan3_4;

public class Item {
    private String name;
    private boolean bo;

    
    public Item(){
        super();
    }

   
    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}
```





### app.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <ImageView
        android:id="@+id/image"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:padding="10dp" />

    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="30dp"
        android:textSize="25sp"
        android:textColor="#000" />

</LinearLayout>
```





### main_menu.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <item
        android:id="@+id/menu_delete"
        app:showAsAction="always"
        android:icon="@drawable/robot"
        android:title="item_delete" />
</menu>
```





### activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">


    <ListView
        android:id="@+id/myList"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="#808080"
        android:dividerHeight="2dp"
        android:listSelector="#600"/>
        <!--android:listSelector="@drawable/color" -->

</LinearLayout>
```









=======


### 1.SimpleAdapter



####  activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ListView
        android:id="@+id/my_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```



#### simpleitem.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView android:id="@+id/names"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:paddingLeft="10dp"
        android:textSize="20sp"/>

    <ImageView android:id="@+id/header"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_gravity="right"
        android:paddingRight="10dp"/>

</LinearLayout>
```



### MainActivity.java

```
package edu.finu.cse.myapplication;
import android.app.Activity;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private List<Map<String,Object>> lists;
    private SimpleAdapter adapter;
    private ListView listView;
    //定义数据
    private String[] names = new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private  int[] imageid = new int[]
            {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,
                    R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.my_list);
        //创建list集合
        List<Map<String,Object>> listItems =
                new ArrayList<>();
        for (int i=0;i<names.length;i++)
        {
            Map<String,Object> listItem =new  HashMap<>();
            listItem.put("header",imageid[i]);
            listItem.put("names",names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simpleitem,
                new String[]{"header","names"}
                ,new int[]{R.id.header,R.id.names});
        list.setAdapter(simpleAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),names[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
```



### 结果

![](./image/1.png)





### 2.AlertDialog



#### activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:text="ANDROID APP"
        android:background="#fffacd"
        android:textColor="#000000"
        android:gravity="center"
        android:textSize="20dp"/>
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Username"
        android:textColor="@color/colorPrimary"
        android:textSize="20dp"/>
    <EditText
        android:id="@+id/password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password"
        android:textSize="20dp"/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginBottom="5dp"
        android:orientation="horizontal"
        android:paddingLeft="5dp"
        android:paddingRight="5dp">
        <Button
            android:id="@+id/button1"
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:text="Cancel"
            android:background="#ffe4e1"
            android:textColor="#000000"/>
        <Button
            android:layout_width="200dp"
            android:layout_height="wrap_content"
            android:text="Sign in"
            android:background="#ffe4e1"
            android:textColor="#000000" />
    </LinearLayout>
</LinearLayout>
```



#### MainActivity.java

```
package edu.finu.cse.myapplication;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder =new  AlertDialog.Builder(this);
        View view = View.inflate(MainActivity.this,R.layout.activity_main,null);
        builder.setView(view);

    }
}
```



#### 

### 结果

![](./image/2.png)









### 3.使用XML定义菜单



#### 

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/txt"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="这是一个测试"/>
</LinearLayout>
```







```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android" >
    <item
        android:title="字体大小">
        <menu>
            <group android:checkableBehavior="single">
                <item android:id="@+id/size1"
                    android:title="小"/>
                <item android:id="@+id/size2"
                    android:title="中"/>
                <item android:id="@+id/size3"
                    android:title="大"/>
            </group>
        </menu>
    </item>
    <item android:id="@+id/item2"
        android:title="普通菜单项">
    </item>
    <item android:id="@+id/item3"
        android:title="字体颜色">
        <menu>
            <group android:checkableBehavior="single">
                <item android:id="@+id/colorRed"
                    android:title="红色"/>
                <item android:id="@+id/colorBlack"
                    android:title="黑色"/>
            </group>
        </menu>
    </item>
</menu>
```





### MainActivity.java

```
package edu.finu.cse.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        txt= findViewById(R.id.txt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.layout.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean  onOptionsItemSelected(MenuItem item){
        switch (item.getItemId())
        {
            case R.id.size1:
                txt.setTextSize(10);
                break;
            case R.id.size2:
                txt.setTextSize(16);
            case R.id.size3:
                txt.setTextSize(20);
                break;
            case R.id.item2:
                Toast.makeText(this,"普通菜单项",Toast.LENGTH_SHORT).show();
            case R.id.colorRed:
                txt.setTextColor(Color.parseColor("#ff0000"));
                break;
            case R.id.colorBlack:
                txt.setTextColor(Color.parseColor("#000000"));
                break;
        }
        return true;
    }


}
```







### 结果

![](./image/3.png)





![](./image/4.png)



![](./image/5.png)



![](./image/6.png)









### 4.ActionMode





### MainActivity.java

```
package edu.finu.cse.shiyan3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names = new String[]{"One", "Two", "Three", "Four", "Five"};
    private int[] imagesIds = new int[]{R.drawable.robot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        List<Map<String, Object>> listitems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
           
            listitem.put("imageview", imagesIds[0]);
            listitem.put("textview", names[i]);
            listitems.add(listitem);
        }
       
        final List<Item> list1= new ArrayList<Item>();
       
        for(int i = 0; i < names.length; i++){
            list1.add(new Item(names[i], false));
        }
        
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, listitems, R.layout.app, new String[]{"textview","imageview" }, new int[]{R.id.text, R.id.image});
        final ListView list = findViewById(R.id.myList);
        
        list.setAdapter(simpleAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new MultiChoiceModeListener() {
            
            int num = 0;
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
               
                if (checked == true) {
                    list1.get(position).setBo(true);
                    
                    simpleAdapter.notifyDataSetChanged();
                    num++;
                } else {
                    list1.get(position).setBo(false);
                    
                    simpleAdapter.notifyDataSetChanged();
                    num--;
                }
                
                mode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
               
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        simpleAdapter.notifyDataSetChanged();
                        num = 0;
                        mode.finish(); 
                        return true;
                    default:
                        return false;
                }
            }

            @SuppressLint("ResourceType")
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                
                num = 0;
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.layout.main_menu,menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
               
                return false;
            }
        });
    }
}

```





### Item.java

```
package edu.finu.cse.shiyan3_4;

public class Item {
    private String name;
    private boolean bo;

    
    public Item(){
        super();
    }

   
    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ",bo=" + bo +
                '}';
    }
}
```





### app.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <ImageView
        android:id="@+id/image"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:padding="10dp" />

    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="30dp"
        android:textSize="25sp"
        android:textColor="#000" />

</LinearLayout>
```





### main_menu.xml

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <item
        android:id="@+id/menu_delete"
        app:showAsAction="always"
        android:icon="@drawable/robot"
        android:title="item_delete" />
</menu>
```





### activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">


    <ListView
        android:id="@+id/myList"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="#808080"
        android:dividerHeight="2dp"
        android:listSelector="#600"/>
        <!--android:listSelector="@drawable/color" -->

</LinearLayout>
```









>>>>>>> “irst commit
![](./image/7.png)