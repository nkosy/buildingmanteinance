package buildingmaintenance.domain;

import java.io.Serializable;
import java.util.Date;
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
    private Date logDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mantainanceLog_id")
    private List<Item> items;
    
    

    public MantainanceLog() {
    }
    
    public MantainanceLog(Builder builder){
        this.mantainanceLog_id = builder.mantainanceLog_id;
        this.description = builder.description;
        this.items = builder.items;
        this.logDate = builder.logDate;
    }

    public static class Builder {

        private long mantainanceLog_id;
        private String description;
        private Date logDate;
        private List<Item> items;

        public Builder(String description) {
            this.description = description;
        }
        
         public Builder description(String value){
            this.description = value;
            return this;
         }

        public Builder logDate(Date value){
            this.logDate = value;
            return this;
        }
         
        public Builder items(List<Item> value){
            this.items = value;
            return this;
        }
         
        public Builder copy(MantainanceLog value){
            this.mantainanceLog_id = value.mantainanceLog_id;
            this.description = value.description;
            this.logDate = value.logDate;
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

    public Date getLogDate() {return logDate;}

    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MantainanceLog that = (MantainanceLog) o;

        if (mantainanceLog_id != that.mantainanceLog_id) return false;
        if (!description.equals(that.description)) return false;
        if (!logDate.equals(that.logDate)) return false;
        return items.equals(that.items);

    }

    @Override
    public int hashCode() {
        int result = (int) (mantainanceLog_id ^ (mantainanceLog_id >>> 32));
        result = 31 * result + description.hashCode();
        result = 31 * result + logDate.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }
}
