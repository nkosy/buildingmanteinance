package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/*@author       Nkosy
 *@Date         23/042015
 *@Description  A tenant can log in mantainace issues they are experiencing 
 */
@Entity
public class MantainanceLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mantainanceLog_id;
    private String description;
     @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mantainanceLog_id")
    private List<Item> items;
    
    

    public MantainanceLog() {
    }
    
    public MantainanceLog(Builder builder){
        this.mantainanceLog_id = builder.mantainanceLog_id;
        this.description = builder.description;
        this.items = builder.items;
    }

    public static class Builder {

        private long mantainanceLog_id;
        private String description;
        private List<Item> items;

        public Builder(String description) {
            this.description = description;
        }
        
         public Builder description(String value){
            this.description = value;
            return this;
        }
         
        public Builder items(List<Item> value){
            this.items = value;
            return this;
        }
         
        public Builder copy(MantainanceLog value){
            this.mantainanceLog_id = value.mantainanceLog_id;
            this.description = value.description;
            this.items = value.items;
            return this;
        }
        
        public MantainanceLog build(){
            return new MantainanceLog(this);
        }
    }

    public long getMantainanceLog_id() {
        return mantainanceLog_id;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.mantainanceLog_id ^ (this.mantainanceLog_id >>> 32));
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.items);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MantainanceLog other = (MantainanceLog) obj;
        return true;
    }
    
    
}
