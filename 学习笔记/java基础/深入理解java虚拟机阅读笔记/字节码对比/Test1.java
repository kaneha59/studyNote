// package java其他内容.其他;

import java.util.Date;

public class Test1 {
    private int aaa = 567;  // 实例变量的变量信息(不包括值)存储在常量池中, 赋值工作隐式地在构造方法中进行(可查看字节码)
    protected String bbb = "my name is abcc";  // 字符串和final值会存储在常量池中
    public Date ddd = new Date();   // 访问权限以 访问标志 的形式保存

    static int staticInt = 99999;   // 静态成员变量赋值操作 在字节码中会被放在static{}静态代码块中, 静态代码块也被视作一个方法
    long codeBlock; // 字段保存在字段表集合

    Test1() {   // 方法保存在方法表集合, 方法表和字段表是以引用常量池索引的方式保存简单名称和描述符的
        this.aaa = 789;
        this.bbb = "hello World!";
        this.staticInt = 987654321;
    }

    Test1(int aaa, String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }

    {
        codeBlock = 2222222222L;    // 代码块的内容在编译后 会偷偷放在每个构造函数中
    }

    public void aaaTest() {
        aaa += aaa;
    }
    // 类中定义了4个实例变量, 1个静态变量, 1个代码块, 2个构造方法, 1个实例方法.
    // 但转成字节码后实际上是2个构造方法,1个实例方法, 1个static代码块(静态变量的赋值操作). 普通代码块被融入到2个构造方法中了.
}
