/**
 * @author CS040
 */
class DRNODE
{
	String name;
	int regno;
	String speciality;
	String qualific;
	int salary;
	int hrs;
	DRNODE right;
	DRNODE left;
	DRNODE(String s,int i,String sp,String q,int h)
	{
	    name=s;
		regno = i;
		speciality = sp;
		hrs = h;
		qualific = q;
		salary = h*1000*4;
		right = null;
		left = null;
	} 
}
