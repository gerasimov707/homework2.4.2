public class Main {

        public static void main (String[]args){
            boolean result = Validator.check("test1234","asdfg","asdfg");
            if (result) {
                System.out.println("логин и пароль верны");
            }else{
                System.out.println("логин и или пароль неверны");
            }

        }
    }

