package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Feedback;
import com.utility.DataConnect;

public class FeedbackDaoimpl implements FeedbackDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean addFeedback(Feedback fd) {
		
		try {
			
			con = DataConnect.getConnection();
			
			ps = con.prepareStatement("insert into Feedback (Name, EmailId, Review, rank1, Suggestion) values (?,?,?,?,?);");
			
			ps.setString(1, fd.getName());
			ps.setString(2, fd.getEmailId());
			ps.setString(3, fd.getReview());
			ps.setInt(4, fd.getRank());
			ps.setString(5, fd.getSuggestion());

			int row = ps.executeUpdate();

			if(row > 0) {
				return true;
			}
			else {
				return false;
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		
		List<Feedback> l = new ArrayList<Feedback>();
		
		try {
			
			con = DataConnect.getConnection();
			
			ps = con.prepareStatement("select * from Feedback;");
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Feedback f = new Feedback();
				
				f.setName(rs.getString("Name"));
				f.setEmailId(rs.getString("EmailId"));
				f.setReview(rs.getString("Review"));
				f.setRank(rs.getInt("rank1"));;
				f.setSuggestion(rs.getString("Suggestion"));
				
				l.add(f);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return l;
	}

}
