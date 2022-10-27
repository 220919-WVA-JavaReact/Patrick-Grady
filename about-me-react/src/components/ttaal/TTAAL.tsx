import Fact from '../fact/Fact';
import './TTAAL.css';

interface IPropsTTAAL{

}

function TTAAL(props: IPropsTTAAL) {

    // in general, data is retrieved from an API/backend
    const facts = [
        {
            id: 1,
            fact: 'I have 2 cats.',
            isTrue: 'truth'
        },
        {
            id: 2,
            fact: 'I have 1 dog.',
            isTrue: 'lie'
        },
        {
            id: 3,
            fact: 'I have twin boys.',
            isTrue: 'truth'
        }
    ]

    return (
        <main>
            <h3>Two truths and a lie:</h3>
            <table>
                {/* <Fact id={facts[0].id} fact={facts[0].fact} isTrue={facts[0].isTrue}  />
                <Fact id={facts[1].id} fact={facts[1].fact} isTrue={facts[1].isTrue}/>
                <Fact id={facts[2].id} fact={facts[2].fact} isTrue={facts[2].isTrue}/> */}
                {
                    facts.map( fact => { 
                        return <Fact id={fact.id} fact={fact.fact} isTrue={fact.isTrue}  />})
                }
            </table>
        </main>
    );
}

export default TTAAL;