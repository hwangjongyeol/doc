package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "잔고조회 Entity", value = "KorbitBalancesEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitBalancesEntity implements Serializable {
	
	private static final long serialVersionUID = 917084280731573500L;

	@ApiModelProperty(value="ticker 명(one,matic,band,mina,bch,vet,btc,ftt,alpha,ctx,btt,klay,lrc,xlm,wbtc,gmt,algo,ron,hbar,zil,looks,eos,ltc,med,rly,flow,\n"
			+ "amp,inj,comp,bsv,rose,ksp,tdrop,audio,nu,mesh,dai,mkr,mana,ada,ftm,eth,bat,bora,link,qtum,fil,atom,rare,ygg,hnt,rari,uni,aergo,waxp,shib,celo,\n"
			+ "dot,bnb,sol,1inch,sushi,wemix,chz,perp,near,dydx,sand,xtz,gala,lunc,rune,fet,etc,axs,krw,xec,doge,xrp,srm,ar,cvx,kda,ocean,usdc,ren,imx,yfi,crv,\n"
			+ "storj,aave,avax,ape,omg,icp,gtc,grt,ens,ksm,ohm,snx,sgb,lpt,ilv,osmo,enj,egld,theta,npt,bit,uma,luna2,stx,trx)"
			, required=false, example="krw", dataType="String")
    private String ticker;

	@ApiModelProperty(value="본인 가지고있는 잔고 조회여부(default:Y)", required=false, example="Y", dataType="String")
    private String my_ticker = "Y";
}
