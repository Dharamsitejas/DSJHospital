class OPNODE
{
	String name;
	int opid;
	String disability;
	int amount;
	DRNODE doc;
	OPNODE right;
	OPNODE left;
	OPNODE(String s,int i,String dp, DRNODE dc)
	{
	    name=s;
		opid = i;
		doc = dc;
		disability = dp;
		amount=dc.salary/100;
		right = null;
		left = null;
	}
}
 