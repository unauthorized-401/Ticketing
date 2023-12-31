package DB;
//이름 규칙 : 테이블명DAO , 테이블명DTO
//CRUD : Create;insert , Read;Select, Update, delete
 
import java.sql.*;
import java.util.Vector;
 




import javax.swing.table.DefaultTableModel;
 
//DB 처리
public class MemberDAO {
 
    private static final String DRIVER
        = "org.gjt.mm.mysql.Driver";
    private static final String URL
        = "jdbc:mysql://127.0.0.1:3307/Ticketing";
   
    private static final String USER = "root"; //DB ID
    private static final String PASS = "1234"; //DB 패스워드
   
    public MemberDAO() {
    }
    /**DB연결 메소드*/
    public Connection getConn(){
    	try{
			Class.forName(DRIVER);//JDBC 드라이버 생성
		}catch(ClassNotFoundException ee)
		{
			System.err.println("DB 연결 드라이버가 없음");
		}
		//2. DB서버와 연결
		Connection conn=null;
		try{
			conn = DriverManager.getConnection(URL, USER, PASS);
		}catch(SQLException ee)
		{
			System.err.println("DB 서버 연결 실패");
		}
        return conn;
    }
   
   
    /**한사람의 회원 정보를 얻는 메소드_List*/
    public Member getMember(String id){
        
        Member dto = new Member();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));
                dto.setName(rs.getString("Name"));
                dto.setTel(rs.getString("tel"));
                dto.setShowtype(rs.getString("showtype"));
                dto.setArea(rs.getString("area"));
                dto.setPayment(rs.getString("payment"));
                dto.setBank(rs.getString("bank"));
                dto.setMonth(rs.getInt("month"));
                dto.setDay(rs.getInt("day"));
                dto.setInning(rs.getInt("inning"));
                dto.setAmount(rs.getInt("amount"));
                dto.setSeatnum(rs.getInt("seatnum"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
    
    /**아이디 비밀번호 찾기 성공시*/
    public Member getMemberIdPwd(String name, String tel){
        
        Member dto = new Member();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where name=? AND tel=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, tel);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));   
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;
    }
    
    /**아이디 체크 메소드*/
    public boolean CheckId(String id){
        
        Member dto = new Member();
        
        boolean exist=false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
            }
            if(dto.getId()!=null)
            {
            	exist=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return exist;    
    }
    /**아이디 찾기 메소드*/
    public boolean FindIdPwd(String name, String tel){
        
        Member dto = new Member();
        
        boolean exist=false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where name=? AND tel=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, tel);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setName(rs.getString("name"));
                dto.setTel(rs.getString("tel"));
            }
            if(dto.getName()!=null&&dto.getTel()!=null)
            {
            	exist=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return exist;    
    }
    

    /**비밀번호 체크 메소드*/
    public boolean CheckPwd(String id,String pwd){
        
        Member dto = new Member();
        
        boolean exist=false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where id=? And pwd=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("pwd"));
            }
            if(dto.getId()!=null&&dto.getPwd()!=null)
            {
            	exist=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return exist;    
    }
    /**회원 등록_Join*/
    public boolean insertMember(Member dto){
       
        boolean ok = false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "insert into member(" +
                        "id,pwd,name,tel,showtype,area," +
                        "payment,bank,month,day,inning,amount) "+
                        "values(?,?,?,?,?,?,?,?,?,?,?,?)";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getTel());
            ps.setString(5, dto.getShowtype());
            ps.setString(6, dto.getArea());
            ps.setString(7, dto.getPayment());
            ps.setString(8, dto.getBank());
            ps.setInt(9, dto.getMonth());
            ps.setInt(10, dto.getDay());
            ps.setInt(11, dto.getInning());
            ps.setInt(12, dto.getAmount());         
            int r = ps.executeUpdate(); //실행 -> 저장
           
           
            if(r>0){
                //System.out.println("가입 성공");   
                ok=true;
            }else{
                System.out.println("가입 실패");
            }
           
               
           
        }catch(Exception e){
            e.printStackTrace();
        }
       
        return ok;
    }
    
    /**예매 정보 등록*/
    public void insertData(String showtype, String area, int seatnum, String payment, String bank, int amount, int month, int day,int inning,String id){
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "update member set " +
                    "showtype=?,area=?,seatnum=?,payment=?,bank=?,amount=?,"+
            		"month=?,day=?,inning=? "+
                    "where id=?";
           
            ps = con.prepareStatement(sql);
            
            ps.setString(1, showtype);
            ps.setString(2, area);
            ps.setInt(3, seatnum);
            ps.setString(4, payment);
            ps.setString(5, bank);
            ps.setInt(6, amount);
            ps.setInt(7, month);
            ps.setInt(8, day);
            ps.setInt(9, inning);
            ps.setString(10, id);
            
            int r = ps.executeUpdate(); //실행 -> 저장
           
            if(r>0){
                //System.out.println("입력 성공");   
            }else{
                System.out.println("입력 실패");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**예매내역 확인 메소드*/
    public boolean FindBook(String id){
        
        Member dto = new Member();
        
        boolean exist=false;
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from member where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
            	dto.setSeatnum(rs.getInt("seatnum"));
            }
            if(dto.getSeatnum()!=0)
            {
            	exist=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return exist;    
    }
    /**예매 취소*/
    public void BookCancel(String id){
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
       
        try{
           
            con = getConn();
            String sql = "update member set " +
                    "showtype=?,area=?,seatnum=?,payment=?,bank=?,amount=?,"+
            		"month=?,day=?,inning=? "+
                    "where id=?";
           
            ps = con.prepareStatement(sql);
            
            ps.setString(1, null);
            ps.setString(2, null);
            ps.setInt(3, 0);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setString(10, id);
            
            int r = ps.executeUpdate(); //실행 -> 저장
           
            if(r>0){
                //System.out.println("취소 성공");   
            }else{
                System.out.println("취소 실패");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
    
    /**회원 탈퇴*/
    public boolean deleteMember(String id, String pwd){
       
        boolean ok =false ;
        Connection con =null;
        PreparedStatement ps =null;
       
        try {
            con = getConn();
            String sql = "delete from member where id=? and pwd=?";
           
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pwd);
            int r = ps.executeUpdate(); // 실행 -> 삭제
           
            if (r>0) ok=true; //삭제됨;
           
        } catch (Exception e) {
            System.out.println(e + "-> 오류발생");
        }      
        return ok;
    } 
   
    public static void main(String args[]){
    	MemberDAO md=new MemberDAO();
    }
}

