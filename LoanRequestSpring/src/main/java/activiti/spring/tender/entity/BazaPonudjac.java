package activiti.spring.tender.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	public class BazaPonudjac implements Serializable {

			@Id
			private long bid;
			
			private String id;
			private String naziv;
			
			private String email;
			private boolean dokumentacija;
			

			public long getBid(){
				return bid;
			}
			
			public void setBid(long bid){
				this.bid=bid;
			}
			
			public String getId(){
				return id;
			}
			
			public void setId(String id){
				this.id=id;
			}
			
			public String getNaziv() {
				return naziv;
			}

			public void setNaziv(String naziv) {
				this.naziv = naziv;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public boolean isDokumentacija() {
				return dokumentacija;
			}

			public void setDokumentacija(boolean dokumentacija) {
				this.dokumentacija = dokumentacija;
			}

	
			
		

			
			
			
			
	}




