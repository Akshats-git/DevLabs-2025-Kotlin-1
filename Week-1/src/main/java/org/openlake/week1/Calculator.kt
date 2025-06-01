
    fun main()
    {
        while (true)
        {
            println("Enter 1st number")
            var a=readLine()?.toDoubleOrNull()
            println("Enter 2nd number")
            var b=readLine()?.toDoubleOrNull()
            println("enter operation +,-,*,/")
            var c=readLine()
            if(a==null||b==null)
            {
                println("wrong input")
                continue;
            }
            val result= when(c)
            {
                "+"->a+b
                "-"->a-b
                "*"->a*b
                "/"->{
                    if(b==0.0)
                    { print("Invalid")
                    }
                    else
                    {
                        a/b
                    }
                }
                else->"Invalid Operation"
            }

            println("result:$result")
            println("Calculate again? 1 for yes 0 for no")
            var d=readLine()?.toDouble()
            if(d==0.0)
                break



        }
        println("Calculator closed");
    }
