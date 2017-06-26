package com.dp.digip.models;

/**
 *  * Created by Nikos on 21/5/2017.
 *   */
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class TransactionId implements Serializable{

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "event_id")
	private Long eventId;

	public TransactionId(){ }

	public TransactionId(Long userId, Long eventId){
		this.userId = userId;
		this.eventId = eventId;	
	}


}
	

